import { WebPlugin } from '@capacitor/core';

import type {
  CapacitorTagManagerPlugin,
  GetAppInstanceIdResult,
  IsEnabledResult,
  LogEventOptions,
  SetConsentOptions,
  SetCurrentScreenOptions,
  SetEnabledOptions,
  SetSessionTimeoutDurationOptions,
  SetUserIdOptions,
  SetUserPropertyOptions,
} from './definitions';

export class CapacitorTagManagerPluginWeb extends WebPlugin implements CapacitorTagManagerPlugin {
  getAppInstanceId(): Promise<GetAppInstanceIdResult> {
    throw new Error('Method not implemented.');
  }
  setConsent(options: SetConsentOptions): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  setUserId(options: SetUserIdOptions): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  setUserProperty(options: SetUserPropertyOptions): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  setCurrentScreen(options: SetCurrentScreenOptions): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  logEvent(options: LogEventOptions): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  setSessionTimeoutDuration(options: SetSessionTimeoutDurationOptions): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  setEnabled(options: SetEnabledOptions): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  isEnabled(): Promise<IsEnabledResult> {
    throw new Error('Method not implemented.');
  }
  resetAnalyticsData(): Promise<void> {
    throw new Error('Method not implemented.');
  }
}
