package com.yemyatthu.restaurantbooker.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


abstract class UseCase<T, Params> {

  private final CompositeDisposable disposables;

  UseCase() {
    this.disposables = new CompositeDisposable();
  }

  /**
   * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
   */
  abstract Observable<T> buildUseCaseObservable(Params params);

  /**
   * Executes the current use case.
   *
   * @param observer {@link DisposableObserver} which will be listening to the observable build
   * by {@link #buildUseCaseObservable(Params)} ()} method.
   * @param params Parameters (Optional) used to build/execute this use case.
   */
  public void execute(DisposableObserver<T> observer, Params params) {

    final Observable<T> observable = this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());

    addDisposable(observable.subscribeWith(observer));
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  public void dispose() {
    if (!disposables.isDisposed()) {
      disposables.dispose();
    }
  }

  /**
   * Dispose from current {@link CompositeDisposable}.
   */
  private void addDisposable(Disposable disposable) {
    disposables.add(disposable);
  }
}