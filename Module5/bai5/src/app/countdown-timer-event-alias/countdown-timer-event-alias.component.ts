import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-countdown-timer-event-alias',
  templateUrl: './countdown-timer-event-alias.component.html',
  styleUrls: ['./countdown-timer-event-alias.component.css']
})
export class CountdownTimerEventAliasComponent implements OnInit, OnChanges, OnDestroy {
  private intervalId = 0;
  message = '';
  remainingTime: string | undefined;

  @Input()
  seconds = "11";

  @Output('timerEnd')
  finish = new EventEmitter<boolean>();

  ngOnChanges(changes: SimpleChanges) {
    if ('seconds' in changes) {
      let v = changes['seconds'].currentValue;
      v = typeof v === 'undefined' ? 11 : v;
      const vFixed = Number(v);
      // @ts-ignore
      parseInt(this.seconds) = Number.isNaN(vFixed) ? 11 : vFixed;
    }
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }

  ngOnInit() {
    this.reset();
    this.start();
  }
  ngOnDestroy() {
    this.clearTimer();
  }

  start() {
    this.countDown();
    // @ts-ignore
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds;
    }
  }
  stop() {
    this.clearTimer();
    this.message = `Holding at T-${this.remainingTime} seconds`;
  }
  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds;
    this.message = `Click start button to start the Countdown`;
  }

  private countDown() {
    this.clearTimer();
    this.intervalId = window.setInterval(() => {
      // @ts-ignore
      this.remainingTime -= 1;
      // @ts-ignore
      if (this.remainingTime === 0) {
        this.message = 'Blast off!';
        this.clearTimer();
        this.finish.emit(true);
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);
  }
}
