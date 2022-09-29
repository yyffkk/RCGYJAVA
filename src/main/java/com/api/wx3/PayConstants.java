package com.api.wx3;

public interface PayConstants {
//    String NOTIFY_URL = "https://148j82s509.51mypc.cn/app/vx/payNotify"; //回调地址
//    String NOTIFY_URL = "http://47.119.164.137:8804/app/vx/payNotify"; //回调地址
    String NOTIFY_URL = "http://star.kaidalai.cn/api/app/user/alipay/payNotify";
    String MCH_ID = "1629188361"; //商户号
    String MCH_SERIAL_NO = "2085562750E921915C3FCAA59B10B0F2BCA2E6F6"; //商户证书序列号
    String API_3KEY = "kaidalai135246xiaomifengzhihuish";   //Api密钥
    String APP_ID = "wxd7bdef0d4849ddb8";     //ApId
    String PACKAGE = "Sign=WXPay";  //签名国定字符串
    static final String privateKey ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDGEmFAMMKqT4EBpAxU/XYqx7YN7zkZDWWAKa63uhD/wn45OoYzyhQI06jRfUKo7vsuwX7uzUKVp9K2+T0D4B0pR/cVQi1wzJOpufHCgFW2HLDWE4HwM1fXwGlsN8t/kemtddmHIrQ1uO4Q+PgeAjpFFC5aMwr1KiLaW8SRZF0L62dk25bndhsWKjvPOFMiqHmNtx1h9iUHDUdjremFb3by65QQeF2GPGS4O+/q4PcIgvvolgTSTdnfpiWmkNDJ4ibUfB9h8Plg8vfJKfn+9wWK8qjwpfS1lxNPQFa0jAY0EKewAiywz6retWw12H9RY29SU2oJtPuRiWK0LGMoMtf9AgMBAAECggEBALCGoPW8f0GaKbd0pSj52960rqQsmA6jydo3S+eihJPsmuIWLpTpfIGBYeuSX15/3o0FFkNt2/HU6A76gk555oNsB+GCYU0uhku11KksBzeOymuAZ0XT/G3kphA0icDgIgreBUhSvZlDf6jQuxDDm3sFSWpKI3HsY7OIJeAOOn7rcsUscdOpzHL6Sf0ytVPFZ5GSFQMNFA3o80PA/5CK/vz7fjiDwH+/0pJOmz0l2rsv2dLX2tJQvhSwnxpt7BVMdnQpihkVivHGsU1D5Y9l8BTCXVgK1y6DXF4mmXw0Lg/yzbXJHOwaakGnLsiKXIXiA7mnZ5yMAC9G80Ea3COVywECgYEA94jBCDJeFjMaotp2c56oXBDJcO5LwEoPy60anr2SRgS//c/4DchuMHzIMdcpflddjJA/EDdZfG3tZc3XoSlY+Lf+5viE7L9slODKztO2r92MBS70d6a/Ps09vdgPoyr/3QnP7/0ZohiDl/PM54dqm3uLQ8o58ZpuVoJW3/aeY+UCgYEAzNiQ1OeI2oJTY45rvuDEWh4b5M/NxtVWZk3AVZvQFFGHpm8OoWyqrKGxUzi0PwH0635pVs8mFWZL7h4Fs5e7g9/UOJNcHN5RdjXf8fczkuMAqk2Pwrk90VhyWMCn0iJXvFcz8YCpRz1npmVZcnro5srYsaTVe4WtrEKaTU6+kjkCgYAbYiOIlpnV9t1Rer1z2O9jD/BY7+OtaAQLUiEJwor19/yNRX55d9zIvGUhLl5Gvb95l1OCpbzeiQKkKntaNsrC6Qfn4UJDNoH6jkuhScaB+g5NXH5q5iVt+yKDZ+2C7XTUrQs1z1gQmImmO7BFRLPEc4xaeXqjgaQHKfAWYp/vCQKBgBS2tXaB7ynBUfNYPHbxvYkrUEDD7pfzjKgNpqxBdDoJwIDI7B7QoTWRqB+1NSzF4uFJSBeaHMy/KmBqssLlTfXY1VnfNMpKhMxCSGHsUE/DGpcd/rJ/DswzeGSXHqE2Dc8itkLucq+cevWte+0Clrh3vI/CDkBOVTB9D6NPmh+pAoGBANUIm2zsu8Zd7H/3+68u5yujzW/66X3HYLFo/WQhCwTT8wTVL1jSQL6MsixNpvUhA+4Te/LQqMtAHuf7MRH73N4qrMSvtQSk70BeIdWmelNuShwAa2umJBsmMacZvUfyn3vBfCYB3t/HzQHECWDmzVe6vv9JkHMs4BmbniiLkdrL";
            //商户私钥

    String NOTIFY_URL_DAILY_PAYMENT = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfDailyPayment";
    String NOTIFY_URL_SHOPPING = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfShoppingRepair";
    String NOTIFY_URL_REPORT_REPAIR = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfReportRepair";
    String NOTIFY_URL_LEASE_RENT_ORDER = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfLeaseRentOrder";
    String NOTIFY_URL_LEASE_RENT_BILL_ORDER = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfLeaseRentBillOrder";
    String NOTIFY_URL_ADVANCE_PAYMENT_ORDER = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfAdvancePaymentOrder";
    String NOTIFY_URL_HOUSEKEEPING_SERVICE_ORDER = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfHousekeepingServiceOrder";
    String NOTIFY_URL_METER_READING_SHARE_DETAIL_ORDER = "http://test.kaidalai.cn/api/app/user/alipay/payNotifyOfMeterReadingShareDetailsOrder";

}
