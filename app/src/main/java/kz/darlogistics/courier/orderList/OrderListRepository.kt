package kz.darlogistics.courier.orderList

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kz.darlogistics.courier.orderList.entity.Orders

class OrderListRepository(val orderListService:OrderListService):OrderListContract.OrderListRepository{
    override fun getNewOrders(userId: Int): Observable<Orders> {
        return orderListService.getNewOrders(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }

    override fun getHistoryOrders(userId: Int): Observable<Orders> {
        return orderListService.getNewOrders(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getRefundsOrders(userId: Int, token: String): Observable<Orders> {
        return orderListService.getRefundsOrders(userId,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }

    override fun getCurrentOrders(userId: Int, token: String):Observable<Orders> {
        return orderListService.getCurrentOrders(userId,token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}