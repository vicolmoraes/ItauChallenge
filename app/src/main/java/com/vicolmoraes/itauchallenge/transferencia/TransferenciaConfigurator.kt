package com.vicolmoraes.itauchallenge.transferencia


enum class TransferenciaConfigurator {

    INSTANCE;

    fun setCleanArchitecture(mainActivity: TransferenciaActivity) {
        val presenter = TransferenciaPresenter()
        presenter.mainActivity = mainActivity

        val interactor = TransferenciaInteractor()
        interactor.presenter = presenter

        mainActivity.interactor = interactor
    }
}