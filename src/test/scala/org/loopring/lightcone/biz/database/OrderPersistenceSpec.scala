/*
 * Copyright 2018 Loopring Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.loopring.lightcone.biz.database

import java.util.concurrent.TimeUnit

import akka.util.Timeout
import org.scalatest._
import slick.basic.DatabaseConfig
import com.typesafe.config.{ Config, ConfigFactory }
import org.loopring.lightcone.biz.model.{ Order, RawOrder, RawOrderEssential }
import org.loopring.lightcone.biz.order.OrderAccessorImpl
import org.loopring.lightcone.lib.time.LocalSystemTimeProvider
import slick.jdbc.JdbcProfile

import scala.concurrent.duration.Duration
import scala.concurrent.{ Await, ExecutionContext }

class OrderPersistenceSpec extends FlatSpec with Matchers {

  "initdb" should "return correct order id" in {
    info("[sbt lib/'testOnly *order pppp']")

    val config = ConfigFactory.parseString("""db {
                                               default {
                                                 profile = "slick.jdbc.MySQLProfile$"
                                                 db {
                                                   url = "jdbc:mysql://13.112.62.24:3306/lightcone_relay?useSSL=false"
                                                   driver ="com.mysql.jdbc.Driver"
                                                   user = "root"
                                                   password = "111111"
                                                   connectionPool = disabled
                                                 }
                                               }
                                             }""")
    val dbconfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig("db.default", config)
    println(dbconfig.toString)
    val conn = new MySQLOrderDatabase(dbconfig, new LocalSystemTimeProvider, ExecutionContext.global)
    println("xxxxxxxxxx")
    println(conn)
    println("yyyyyyyyyy")

    //    val r = conn.orders.createTable();
    //    Await.result(r, Duration(10, TimeUnit.SECONDS))
    //
    //    Thread.sleep(100000)

    val orderA = new OrderAccessorImpl(conn)
    val ore = RawOrderEssential(hash = "0xdkfjdksjf", amountS = "0xkdjfdjfk")
    val ro = RawOrder(rawOrderEssential = ore, version = "2")
    val o = Order(rawOrder = ro, broadcastTime = 10)

    val saveRst = orderA.saveOrder(o)
    val wr = Await.result(saveRst, Duration(2, TimeUnit.SECONDS))
    println(saveRst)
    println(wr)

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
