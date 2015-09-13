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

## Why would I use this?!?!

I dislike PermissionsEx for the simple reason that the `/pex` command is incredibly hard to read, or rather it's incredibly hard to find what you want in it. It's an inconvenience to constantly open the wiki pages and check arguments, syntax, etc. That's why I'd use this plugin, I don't know about you.
