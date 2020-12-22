package net.ins.bpm.camundapoc.postloan.util

import java.lang.IllegalArgumentException

internal const val BP_PREFIX = "PL_"

fun String.toBusinessKey() = "${BP_PREFIX}_$this"

fun String.businessKeyToUserId() = if (startsWith(BP_PREFIX)) substring(BP_PREFIX.length) else throw IllegalArgumentException("Not a business key")