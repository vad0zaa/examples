@SmokeTest
Feature:
  Kak web developer
  Ja hochu ubeditsja
  chto website otobrazaetsja pravilno
  v brauzere Android telefona

  @MobileBrowserTest
  Scenario:
    Given user otkryvaet browser
    When on proverjaet sait
    Then website title dolzen byt Google
