import { WebPlugin } from '@capacitor/core';

import type { CapacitorTagManagerPlugin } from './definitions';

export class CapacitorTagManagerPluginWeb extends WebPlugin implements CapacitorTagManagerPlugin {
  logEvent(): Promise<void> {
    throw new Error('Method not implemented.');
  }
}
