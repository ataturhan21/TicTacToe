#!/usr/bin/env bash
set -euo pipefail

cd -- "$(dirname -- "${BASH_SOURCE[0]}")/tictactoe"

exec mvn clean javafx:run "$@"
