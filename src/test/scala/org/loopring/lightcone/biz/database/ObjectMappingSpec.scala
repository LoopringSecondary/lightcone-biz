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

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.typesafe.config.ConfigFactory
import org.loopring.lightcone.biz.database.entity.OrderEntity
import org.loopring.lightcone.biz.mapper.{ ObjMapper, ObjectMapper }
import org.loopring.lightcone.biz.model.{ RawOrder, RawOrderEssential }
import org.loopring.lightcone.lib.time.LocalSystemTimeProvider
import org.scalatest._
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

class ObjectMappingSpec extends FlatSpec with Matchers {

  case class SourceClass(id: Int, name: String)
  case class TargetClass(name: String)

  case class RawOrderTest(
      //      var targetClass: TargetClass = TargetClass("123"),
      test: String = "",
      version: String = "",
      tokenSpendableS: String = "",
      tokenSpendableFee: String = "",
      brokerSpendableS: String = "",
      brokerSpendableFee: String = "",
      sig: String = "",
      dualAuthSig: String = "",
      waiveFeePercentage: Int = 0,
      dualPrivateKey: String = ""
  )

  "object map" should "object map" in {
    info("[sbt lib/'testOnly *order pppp']")
    //    val mapper = DozerBeanMapperBuilder.buildDefault()
    val src = OrderEntity(hash = "sdlfjkdfjk", amountB = "0xxddddd", dealtAmountB = "0x111111", version = "aaa")
    //    var dest = RawOrder()
    //    mapper.map(src, dest)
    //    println(dest)
    //    println(dest.version)

    //    val dest = ObjectMapper.convertTo[OrderEntity, RawOrderTest](src)
    //    println(dest)

    import org.loopring.lightcone.biz.mapper.Macros._

//    implicit val mapper = objMapper[OrderEntity, RawOrderTest]

//    val dest = ObjMapper.mapValue(src)
//    println(dest.version)

    //    println(ObjectMapper.convertTo[SourceClass, TargetClass](SourceClass(11, "1233")))

    //
    //    val config = ConfigFactory.empty()
    //    val dbconfig: DatabaseConfig[JdbcProfile] = DatabaseConfig.forConfig("db.default", config)
    //    val conn = new MySQLOrderDatabase(dbconfig, new LocalSystemTimeProvider, ExecutionContext.global)

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
