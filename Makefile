SHELL := /bin/bash

# bumpversion
.PHONY: patch
patch: # bump version number patch
	docker run --rm -it --user $(shell id -u):$(shell id -g) -v "$(shell pwd):/app" apitable/bumpversion:latest bumpversion patch

.PHONY: minor
minor: # bump version number patch
	docker run --rm -it --user $(shell id -u):$(shell id -g) -v "$(shell pwd):/app" apitable/bumpversion:latest bumpversion minor

.PHONY: major
major: # bump version number patch
	docker run --rm -it --user $(shell id -u):$(shell id -g) -v "$(shell pwd):/app" apitable/bumpversion:latest bumpversion major


define BUMPVERSION_TXT
Which version number do you want to bump?
  1) patch
  2) minor
  3) major

endef
export BUMPVERSION_TXT
bumpversion: ## bumpversion, patch? minor? major?
	@echo "$$BUMPVERSION_TXT" ;\
	read -p "NUMBER>>" NUMBER ;\
	if [ "$$NUMBER" = "1" ]; then make patch; fi ;\
	if [ "$$NUMBER" = "2" ]; then make minor; fi ;\
	if [ "$$NUMBER" = "3" ]; then make major; fi ;\
