package com.yemyatthu.restaurantbooker.domain.interactor;

import io.reactivex.observers.DisposableObserver;

public class DefaultObserver<T> extends DisposableObserver<T> {
  @Override public void onNext(T t) {
    // no-op by default.
  }

  @Override public void onComplete() {
    // no-op by default.
  }

  @Override public void onError(Throwable exception) {
    // no-op by default.
  }
}
