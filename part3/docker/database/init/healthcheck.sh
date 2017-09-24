#!/bin/bash
#Check if datbase cgm exist
if [[ ! -z "`mysql -u root -padmin -qfsBe "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME='cgm'" 2>&1`" ]];
then
  exit 0
else
  exit 1
fi