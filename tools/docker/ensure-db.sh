#!/bin/bash
set -euo pipefail

host="${DB_HOST:-postgres}"
user="${DB_USERNAME:-library}"
db="${DB_NAME:-library-is-db}"
export PGPASSWORD="${DB_PASSWORD:-library}"

until pg_isready -h "$host" -U "$user" -d postgres; do
  echo "Waiting for Postgres at ${host}..."
  sleep 1
done

exists="$(psql -h "$host" -U "$user" -d postgres -tAc "SELECT 1 FROM pg_database WHERE datname='${db}'")"

if [[ "$exists" != "1" ]]; then
  psql -h "$host" -U "$user" -d postgres -v ON_ERROR_STOP=1 -c "CREATE DATABASE \"${db}\";"
  echo "Database '${db}' created"
else
  echo "Database '${db}' already exists"
fi
