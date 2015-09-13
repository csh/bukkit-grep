bukkit-grep
===========

Simple plugin for filtering command output.

## Usage

If you can't figure this out you probably shouldn't be using this plugin in the first place, but I'll spoon feed anyway.

```
grep <pattern> <command> [arguments ...]
```

#### Example

Apparently the last example wasn't clear enough. `sass++;`

```
grep bukkit help 1
```

Will only send messages usually sent by `/help 1` that match the following expression, `.*bukkit.*`.
