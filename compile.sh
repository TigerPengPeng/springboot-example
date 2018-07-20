#!/usr/bin/env bash
echo "env="$1
mvn clean -U package -P$1 -DskipTests=true