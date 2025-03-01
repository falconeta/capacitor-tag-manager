import { registerPlugin } from '@capacitor/core';

import type { CapacitorTagManagerPlugin } from './definitions';

const CapacitorTagManager =
  registerPlugin<CapacitorTagManagerPlugin>(
    'CapacitorTagManager',
    {
      web: () =>
        import('./web').then(m => new m.CapacitorTagManagerPluginWeb()),
    },
  );

export * from './definitions';
export { CapacitorTagManager };
