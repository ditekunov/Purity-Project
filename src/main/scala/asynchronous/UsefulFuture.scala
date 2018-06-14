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
  }
}
