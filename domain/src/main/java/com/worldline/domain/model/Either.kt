package com.worldline.domain.model

sealed class Either<L, R> {
    class Left<L, R>(val error: L) : Either<L, R>() {
        override fun toString(): String = "Left $error"
    }

    class Right<L, R>(val sucess: R) : Either<L, R>() {
        override fun toString(): String = "Right $sucess"
    }

    infix fun <Rp> bind(f: (R) -> (Either<L, Rp>)): Either<L, Rp> {
        return when (this) {
            is Left<L, R> -> Left(this.error)
            is Right<L, R> -> f(this.sucess)
        }
    }

    infix fun <Rp> map(f: (R) -> (Either<L, Rp>)): Either<L, Rp> {
        return when (this) {
            is Left<L, R> -> Left(this.error)
            is Right<L, R> -> f(this.sucess)
        }
    }

    infix fun <Rp> seq(e: Either<L, Rp>): Either<L, Rp> = e
}