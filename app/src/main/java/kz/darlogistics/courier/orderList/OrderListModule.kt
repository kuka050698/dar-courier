package kz.darlogistics.courier.orderList

import kz.darlogistics.courier.core.api.Constants
import kz.darlogistics.courier.core.createService
import org.koin.dsl.module.module

val orderListModule = module{
    //    single{CurrentOrderListService.create()}
//    single{OrderListService.create()}
    single{ createService<OrderListService>(get(), Constants.url) }
//    factory { CurrentOrderListPresenter() as OrderListContract.OrderListPresenter }
//    factory{(currentOrderListPresenter:OrderListContract.OrderListPresenter)->CurrentOrderListRepository(get(), currentOrderListPresenter) as OrderListContract.OrderListRepository}
    factory{OrderListRepository(get()) as OrderListContract.OrderListRepository}
    factory { OrderListPresenter() as OrderListContract.OrderListPresenter }
    factory("current") {CurrentOrderListFragment() as OrderListContract.OrderListView }
    factory("new") {NewOrderListFragment() as OrderListContract.OrderListView  }
    factory("history") { HistoryOrderListFragment() as OrderListContract.OrderListView }
    factory("return"){ReturnOrderListFragment() as OrderListContract.OrderListView}
}