package kz.darlogistics.courier.orderList

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_current_order_list.*

class CurrentOrderListFragment : BaseOrderListFragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.getCurrentOrders()
        super.onViewCreated(view, savedInstanceState)
        swipeListOrder.setOnRefreshListener {
            presenter.getUpdatedCurrentOrders()
        }
    }
}