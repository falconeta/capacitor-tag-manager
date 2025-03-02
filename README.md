# @falconeta/capacitor-tag-manager


## Install

```bash
npm install @falconeta/capacitor-tag-manager
npx cap sync
```

## API

<docgen-index>

* [`getAppInstanceId()`](#getappinstanceid)
* [`setConsent(...)`](#setconsent)
* [`setUserId(...)`](#setuserid)
* [`setUserProperty(...)`](#setuserproperty)
* [`setCurrentScreen(...)`](#setcurrentscreen)
* [`logEvent(...)`](#logevent)
* [`setSessionTimeoutDuration(...)`](#setsessiontimeoutduration)
* [`setEnabled(...)`](#setenabled)
* [`isEnabled()`](#isenabled)
* [`resetAnalyticsData()`](#resetanalyticsdata)
* [Interfaces](#interfaces)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getAppInstanceId()

```typescript
getAppInstanceId() => Promise<GetAppInstanceIdResult>
```

Retrieves the app instance id.

Only available for Android and iOS.

**Returns:** <code>Promise&lt;<a href="#getappinstanceidresult">GetAppInstanceIdResult</a>&gt;</code>

**Since:** 1.4.0

--------------------


### setConsent(...)

```typescript
setConsent(options: SetConsentOptions) => Promise<void>
```

Sets the user's consent mode.

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#setconsentoptions">SetConsentOptions</a></code> |

**Since:** 6.0.0

--------------------


### setUserId(...)

```typescript
setUserId(options: SetUserIdOptions) => Promise<void>
```

Sets the user ID property.

| Param         | Type                                                          |
| ------------- | ------------------------------------------------------------- |
| **`options`** | <code><a href="#setuseridoptions">SetUserIdOptions</a></code> |

**Since:** 0.1.0

--------------------


### setUserProperty(...)

```typescript
setUserProperty(options: SetUserPropertyOptions) => Promise<void>
```

Sets a custom user property to a given value.

| Param         | Type                                                                      |
| ------------- | ------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setuserpropertyoptions">SetUserPropertyOptions</a></code> |

**Since:** 0.1.0

--------------------


### setCurrentScreen(...)

```typescript
setCurrentScreen(options: SetCurrentScreenOptions) => Promise<void>
```

Sets the current screen name.

| Param         | Type                                                                        |
| ------------- | --------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setcurrentscreenoptions">SetCurrentScreenOptions</a></code> |

**Since:** 0.1.0

--------------------


### logEvent(...)

```typescript
logEvent(options: LogEventOptions) => Promise<void>
```

Logs an app event.

| Param         | Type                                                        |
| ------------- | ----------------------------------------------------------- |
| **`options`** | <code><a href="#logeventoptions">LogEventOptions</a></code> |

**Since:** 0.1.0

--------------------


### setSessionTimeoutDuration(...)

```typescript
setSessionTimeoutDuration(options: SetSessionTimeoutDurationOptions) => Promise<void>
```

Sets the duration of inactivity that terminates the current session.

Only available for Android and iOS.

| Param         | Type                                                                                          |
| ------------- | --------------------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setsessiontimeoutdurationoptions">SetSessionTimeoutDurationOptions</a></code> |

**Since:** 0.1.0

--------------------


### setEnabled(...)

```typescript
setEnabled(options: SetEnabledOptions) => Promise<void>
```

Enables/disables automatic data collection.
The value does not apply until the next run of the app.

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#setenabledoptions">SetEnabledOptions</a></code> |

**Since:** 0.1.0

--------------------


### isEnabled()

```typescript
isEnabled() => Promise<IsEnabledResult>
```

Returns whether or not automatic data collection is enabled.

Only available for Web.

**Returns:** <code>Promise&lt;<a href="#isenabledresult">IsEnabledResult</a>&gt;</code>

**Since:** 0.1.0

--------------------


### resetAnalyticsData()

```typescript
resetAnalyticsData() => Promise<void>
```

Clears all analytics data for this app from the device.
Resets the app instance id.

Only available for Android and iOS.

**Since:** 0.1.0

--------------------


### Interfaces


#### GetAppInstanceIdResult

| Prop                | Type                | Description                                                                                                                                                                                             | Since |
| ------------------- | ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ----- |
| **`appInstanceId`** | <code>string</code> | The app instance id. Not defined if `FirebaseAnalytics.<a href="#consenttype">ConsentType</a>.ANALYTICS_STORAGE` has been set to `FirebaseAnalytics.<a href="#consentstatus">ConsentStatus</a>.DENIED`. | 1.4.0 |


#### SetConsentOptions

| Prop         | Type                                                    | Description         | Since |
| ------------ | ------------------------------------------------------- | ------------------- | ----- |
| **`type`**   | <code><a href="#consenttype">ConsentType</a></code>     | The consent type.   | 6.0.0 |
| **`status`** | <code><a href="#consentstatus">ConsentStatus</a></code> | The consent status. | 6.0.0 |


#### SetUserIdOptions

| Prop         | Type                        | Since |
| ------------ | --------------------------- | ----- |
| **`userId`** | <code>string \| null</code> | 0.1.0 |


#### SetUserPropertyOptions

| Prop        | Type                        | Since |
| ----------- | --------------------------- | ----- |
| **`key`**   | <code>string</code>         | 0.1.0 |
| **`value`** | <code>string \| null</code> | 0.1.0 |


#### SetCurrentScreenOptions

| Prop                      | Type                        | Description                         | Default           | Since |
| ------------------------- | --------------------------- | ----------------------------------- | ----------------- | ----- |
| **`screenName`**          | <code>string \| null</code> |                                     |                   | 0.1.0 |
| **`screenClassOverride`** | <code>string \| null</code> | Only available for Android and iOS. | <code>null</code> | 0.1.0 |


#### LogEventOptions

| Prop         | Type                                 | Description                | Since |
| ------------ | ------------------------------------ | -------------------------- | ----- |
| **`name`**   | <code>string</code>                  | The event name.            | 0.1.0 |
| **`params`** | <code>{ [key: string]: any; }</code> | The optional event params. | 0.1.0 |


#### SetSessionTimeoutDurationOptions

| Prop           | Type                | Description          | Default           | Since |
| -------------- | ------------------- | -------------------- | ----------------- | ----- |
| **`duration`** | <code>number</code> | Duration in seconds. | <code>1800</code> | 0.1.0 |


#### SetEnabledOptions

| Prop          | Type                 | Since |
| ------------- | -------------------- | ----- |
| **`enabled`** | <code>boolean</code> | 0.1.0 |


#### IsEnabledResult

| Prop          | Type                 | Since |
| ------------- | -------------------- | ----- |
| **`enabled`** | <code>boolean</code> | 0.1.0 |


### Enums


#### ConsentType

| Members                      | Value                                  | Since |
| ---------------------------- | -------------------------------------- | ----- |
| **`AdPersonalization`**      | <code>'AD_PERSONALIZATION'</code>      | 6.0.0 |
| **`AdStorage`**              | <code>'AD_STORAGE'</code>              | 6.0.0 |
| **`AdUserData`**             | <code>'AD_USER_DATA'</code>            | 6.0.0 |
| **`AnalyticsStorage`**       | <code>'ANALYTICS_STORAGE'</code>       | 6.0.0 |
| **`FunctionalityStorage`**   | <code>'FUNCTIONALITY_STORAGE'</code>   | 6.0.0 |
| **`PersonalizationStorage`** | <code>'PERSONALIZATION_STORAGE'</code> | 6.0.0 |


#### ConsentStatus

| Members       | Value                  | Since |
| ------------- | ---------------------- | ----- |
| **`Granted`** | <code>'GRANTED'</code> | 6.0.0 |
| **`Denied`**  | <code>'DENIED'</code>  | 6.0.0 |

</docgen-api>
