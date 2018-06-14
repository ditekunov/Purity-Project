import java.util.concurrent.TimeUnit


import scala.concurrent.duration.{Duration, TimeUnit}
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

object UsefulFuture {

  /**
    * Contains functions, affecting futures.
    *
    * Purity project by Daniil Tekunov.
    */
  implicit class NiceFuture[T](future: Future[T])(implicit ec: ExecutionContext) {

    /**
      * Applies a given function to a result of a future without affecting the future itself
      */
    def bypassOnComplete[A](function: T => A): Future[T] = {
      future onComplete {
        case Success(outcome) => function(outcome)
        case Failure(_) => Future.failed(new Exception)
      }
      future
    }

    /**
      * Throws a given exception if a future failed and applies a given function to it
      */
    def ifFailure(functionFail: => Unit, exception: Option[Throwable] = None): Future[T] = {
      future transformWith {
        case Failure(ex) =>
          functionFail
          Future.failed(exception getOrElse ex)

        case _ => future
      }
    }

    /**
      * Returns the result of a future within given time
      */
    def result(awaitTime: Long, timeUnit: TimeUnit = TimeUnit.MICROSECONDS): T =
      Await.result(future, Duration(awaitTime, timeUnit))


    /**
      * Completes first future and returns second future if first one completes
      */
    def completeAndThen(anotherFuture: Future[T]): Future[T] = {
      future andThen {
        case Success(_) => anotherFuture
        case Failure(ex) => ex
      }
    }

    /**
      * Completes first future and then completes second future
      */
    def completeAndThenComplete(anotherFuture: Future[T]): Future[T] = {
      future andThen {
        case Success(_) => anotherFuture andThen {
          case Success(x) => x
          case Failure(ex) => ex
        }
        case Failure(ex) => ex
      }
    }
  }
}
