package xyz.discretezoo.web.db.MBGENMatrixWithCharacteristicSView
import java.util.UUID
import slick.jdbc.GetResult
import xyz.discretezoo.web.PlainSQLSupport
import xyz.discretezoo.web.ZooPostgresProfile.api._

object MatrixWithCharacteristicSViewPlainQuery extends PlainSQLSupport[MatrixWithCharacteristicSView] {

  override val columns: String =
    """
      |"MBGEN_MATRIXWITHCHARACTERISTICSVIEW"."ID",
      |"MBGEN_MATRIXWITHCHARACTERISTICSVIEW"."POSITIVE_DEFINITE",
      |"MBGEN_MATRIXWITHCHARACTERISTICSVIEW"."MAT",
      |"MBGEN_MATRIXWITHCHARACTERISTICSVIEW"."TRACE",
      |"MBGEN_MATRIXWITHCHARACTERISTICSVIEW"."ORTHOGONAL",
      |"MBGEN_MATRIXWITHCHARACTERISTICSVIEW"."EIGENVALUES"
    """.stripMargin
  override val from: String = "MBGEN_MATRIXWITHCHARACTERISTICSVIEW"
  override implicit val getResult: GetResult[MatrixWithCharacteristicSView] = GetResult(r =>
    MatrixWithCharacteristicSView(r.nextObject.asInstanceOf[UUID], r.<<, r.<<[Seq[Int]].toList, r.<<, r.<<, r.<<[Seq[Int]].toList)
  )

  val inCollection: Map[String, String] = Map(
    "MatrixWithCharacteristicSView" -> "ID"
  )

}