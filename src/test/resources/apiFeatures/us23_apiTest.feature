Feature: Admin can create Vice Dean account

  Scenario Outline: Verify ViceDean account that is created (Api)

    Given Take ViceDean that is created with get request "<userId>"
    Then Verify ViceDean information : userId="<userId>", username="<username>", name="<name>", surname="<surname>", birthDay="<birthDay>", ssn="<ssn>", birthPlace="<birthPlace>", phoneNumber="<phoneNumber>", gender="<gender>"

    Examples:
      | userId | username   | name       | surname | birthDay   | ssn         | birthPlace | phoneNumber  | gender |
      | 469    | Team11Erol | Team11Erol | Team11  | 2000-09-07 | 435-66-9676 | Turkey     | 567-494-7765 | MALE   |