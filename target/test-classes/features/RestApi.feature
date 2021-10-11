Feature: Hepsiburada Rest Api

  Scenario: Urun Bazli Kontrol
    Given Name 'apple', price '3',stock '100' olan urun oldugu kontrol edilir.

  Scenario: Yeni Endpoint Kontrol
    Given Endpoint bazli kontrol edilir.

  Scenario: Urunlerin Varligi Kontrol
    Given Apideki urunlerin varligi kontrol edilir.

  Scenario: Urun Ekleme
    Given id '4', name 'samsung', price '20',stock '13' ozellikli urun eklenir.
