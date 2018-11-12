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

package org.loopring.lightcone.biz.model

import org.loopring.lightcone.biz.enum.MarketSide.MarketSide
import org.loopring.lightcone.biz.enum.OrderStatus._
import org.loopring.lightcone.biz.enum.OrderType.OrderType
import org.loopring.lightcone.biz.enum.SoftCancelType.SoftCancelType

case class OrderQuery(statuses: Seq[OrderStatus], owner: String, market: String, hashes: Seq[String], sideOpt: Option[MarketSide], orderTypeOpt: Option[OrderType])

case class CancelOrderOption(hash: String, cutoffTime: Long, market: String, cancelType: SoftCancelType, owner: String)

case class Order(
    var rawOrder: RawOrder,
    updatedBlock: Long,
    dealtAmountS: String,
    dealtAmountB: String,
    cancelledAmountS: String,
    cancelledAmountB: String,
    status: OrderStatus,
    broadcastTime: Int,
    powNonce: Long,
    market: String,
    side: String,
    price: Double,
    orderType: String
)

case class RawOrder(
    var rawOrderEssential: RawOrderEssential,
    version: String,
    tokenSpendableS: String,
    tokenSpendableFee: String,
    brokerSpendableS: String,
    brokerSpendableFee: String,
    sig: String,
    dualAuthSig: String,
    waiveFeePercentage: Int,
    dualPrivateKey: String
)

case class RawOrderEssential(
    owner: String,
    tokenS: String,
    tokenB: String,
    amountS: String,
    amountB: String,
    validSince: Long,
    dualAuthAddress: String,
    broker: String,
    orderInterceptor: String,
    wallet: String,
    validUntil: Long,
    allOrNone: Boolean,

    feeToken: String,
    feeAmount: String,
    feePercentage: Int,
    tokenSFeePercentage: Int,
    tokenBFeePercentage: Int,
    tokenRecipient: String,
    walletSplitPercentage: Int,
    hash: String
)

