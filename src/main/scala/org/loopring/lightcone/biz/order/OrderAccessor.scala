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

package org.loopring.lightcone.biz.order

import org.loopring.lightcone.biz.enum.OrderSaveResult.OrderSaveResult
import org.loopring.lightcone.biz.model._

import scala.concurrent.Future

trait OrderAccessor {
  def saveOrder(order: Order): Future[OrderSaveResult]
  def getOrderByHash(orderHash: String): Future[Option[Order]]
  def pageQueryOrders(optOrderQuery: Option[OrderQuery], optPage: Option[PaginationQuery]): Future[PaginationResult]
  def softCancelOrders(cancelOrderOption: Option[CancelOrderOption]): Future[Seq[Order]]
}
