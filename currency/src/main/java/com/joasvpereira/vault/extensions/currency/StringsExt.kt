package com.joasvpereira.vault.extensions.currency

import java.util.Currency

fun String.currencySymbol():String{
    return Currency.getInstance(this).symbol
}