#!/bin/bash
git filter-branch --force --index-filter \
'git rm --cached --ignore-unmatch db/data/db/WiredTiger.turtle' \
--prune-empty --tag-name-filter cat -- --all
