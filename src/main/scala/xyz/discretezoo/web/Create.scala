package xyz.discretezoo.web

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import slick.lifted.TableQuery
import xyz.discretezoo.web.db.ZooDb

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}
import xyz.discretezoo.web.ZooPostgresProfile.api._
import xyz.discretezoo.web.db.MBGENMatrixWithCharacteristicS.MatrixWithCharacteristicSTable
import xyz.discretezoo.web.db.MBGENMatrixS.MatrixSTable

object Create {

  def main(args: Array[String]): Unit = {

    implicit val system: ActorSystem = ActorSystem("ZooActors")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContext = system.dispatcher

  object tbMatrixWithCharacteristicS extends TableQuery(new MatrixWithCharacteristicSTable(_))
  object tbMatrixS extends TableQuery(new MatrixSTable(_))
  val viewMatrixWithCharacteristicS: DBIO[Int] =
    sqlu"""
        CREATE VIEW "MBGEN_MATRIXWITHCHARACTERISTICSVIEW" AS
        SELECT "MBGEN_MATRIXWITHCHARACTERISTICS"."ID", "MBGEN_MATRIXWITHCHARACTERISTICS"."POSITIVE_DEFINITE", "MBGEN_MATRIXS"."MAT", "MBGEN_MATRIXS"."TRACE", "MBGEN_MATRIXS"."ORTHOGONAL", "MBGEN_MATRIXS"."EIGENVALUES"
        FROM "MBGEN_MATRIXWITHCHARACTERISTICS"
        JOIN "MBGEN_MATRIXS" ON "MBGEN_MATRIXS"."ID" = "MBGEN_MATRIXWITHCHARACTERISTICS"."MATRIXID";
    """
     

    ZooDb.db.run(DBIO.seq(
      tbMatrixWithCharacteristicS.schema.createIfNotExists, tbMatrixS.schema.createIfNotExists
    )).onComplete({
      case Success(result)  => println("Tables existed before or were created.")
      case Failure(failure) => println("Failed to create tables.")
    })

    ZooDb.db.run(DBIO.seq(
      viewMatrixWithCharacteristicS
    )).onComplete({
      case Success(result)  => println("Created view.")
      case Failure(failure) => println("Failed to create view.")
    })

  }

}