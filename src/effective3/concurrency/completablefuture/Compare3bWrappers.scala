package effective3.concurrency.completablefuture

import scala.concurrent.Future


class Compare3bWrappers {
  // data structures
  case class Rss(feedAddress: String)

  // I/O operations: non-blocking, asynchronous
  def fetchFromDb[T](entityClass: Class[T], id: Long): Future[T] = ???
  def sendHttpGet(url: String): Future[String] = ???

  // the business logic: asynchronous
  def fetchRssContent(rssIds: List[Long]): Future[List[String]] = {
    // all I/O operations will run concurrently
    val listOfFutureContents = rssIds
      .map(rssId => fetchFromDb(classOf[Rss], rssId))
      .map(_.flatMap(rss => sendHttpGet(rss.feedAddress)))

    // combining a list of futures into a future of a list
    Future.sequence(listOfFutureContents)
  }

}
