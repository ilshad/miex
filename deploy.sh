#!/bin/bash

SOURCE=~/Projects/foo/bar
TARGET=example.com:./foo/bar

exec rsync -arvuz $SOURCE $TARGET
