package com.example.moneyapp.data.listDataSource

import com.example.moneyapp.R
import com.example.moneyapp.model.Service

class ServiceDataSource {
    fun getServiceData(): List<Service> {
        val services = mutableListOf<Service>()
        services.add(
            Service(R.string.transfer, R.drawable.ic_transfer)
        )
        services.add(
            Service(R.string.transaction, R.drawable.ic_transaction)
        )
        services.add(
            Service(R.string.cards, R.drawable.ic_cards)
        )
        services.add(
            Service(R.string.account, R.drawable.ic_account)
        )
        return services
    }
}