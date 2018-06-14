import java.util.concurrent.TimeUnit


import scala.concurrent.duration.{Duration, TimeUnit}
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

package object futureHelper {

  implicit class NiceFuture[T](future: Future[T])(implicit ec: ExecutionContext) {
    
    def bypassOnComplete[A](function: T => A): Future[T] = {
      future onComplete {
        case Success(outcome) => function(outcome)
        case Failure(_) => Future.failed(new Exception)
      }
      future
    }
    
     def ifFailure(functionFail: => Unit, exception: Option[Throwable] = None): Future[T] = {
      future transformWith {
        case Failure(ex) =>
          functionFail
          Future.failed(exception getOrElse ex)

        case _ => future
      }
    }
    
    def result(awaitTime: Long, timeUnit: TimeUnit = TimeUnit.MICROSECONDS): T = 
      Await.result(future, Duration(awaitTime, timeUnit))
    
    def completeAndThen(anotherFuture: Future[T]): Future[T] = {
      future andThen {
        case Success(_) => anotherFuture
        case Failure(ex) => ex
      }
    }
  }
}
