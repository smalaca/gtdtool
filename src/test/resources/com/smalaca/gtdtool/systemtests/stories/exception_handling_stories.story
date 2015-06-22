Narrative:
Veryfication of exception handling

Scenario: Entity not found
Given Undefined Item with id 13
When converting to Project
Then Undefined Item was not found