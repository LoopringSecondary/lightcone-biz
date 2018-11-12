package org.loopring.lightcone.biz.database

import org.scalatest._
import slick.basic.DatabaseConfig
import com.typesafe.config.{Config, ConfigFactory}
import org.loopring.lightcone.lib.time.LocalSystemTimeProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

class OrderPersistanceSpec extends FlatSpec with Matchers {

  "save order" should "return correct order id" in {
    info("[sbt lib/'testOnly *order pppp']")

    val config = ConfigFactory.empty()
    val dbconfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig("db.default", config)
    val conn = new MySQLOrderDatabase(dbconfig, new LocalSystemTimeProvider, ExecutionContext.global)

//    val ring = Ring(
//      orders = Seq(order1, order2),
//      feeReceipt = "0x0511ebd550bc240c7d167d9ecbf82eb5156dd787",
//      miner = "0xf357eb986926808b113c79ba5975dc1bae1fba79",
//      transactionOrigin = "0x73d8f963642a21663e7617f796c75c99804b9e3b",
//      sig = "0x00411ce2bb66d38d0ffd98d73abdfc12563aee1b993e5c9a1d6b87bf9491c0ca2dd8c55aad23ddc053ad4f6ecf0513d857147d9f7445127607e502214a82d9854dc72b",
//      ringOrderIndex = Seq(Seq(0, 1))
//    )
//
//    val result = generator.serialize(ring)
//    info("generated ring data: " + result)
//    result should be(originInput)
  }

}
