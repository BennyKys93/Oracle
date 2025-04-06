openapi: 3.0.1
info:
title: Survey Management API
description: API for sending survey data
version: 1.0.0
paths:
/surveys:
post:
summary: Send survey information
requestBody:
required: true
content:
application/json:
schema:
$ref: '#/components/schemas/SurveyData'
responses:
'200':
description: Survey received successfully
'400':
description: Invalid data
components:
schemas:
SurveyData:
type: object
properties:
age:
type: integer
gender:
type: string
description: "Gender of the participant. Allowed values: male, female, other."
region:
type: string
surveyID:
type: string
score:
type: integer
minimum: 1
maximum: 5
required:
- age
- gender
- region
- surveyID
- score
