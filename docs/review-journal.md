# Review Journal

This journal records the domain cases that matter before widening the public API.

The local checks classify each case as `ship`, `watch`, or `hold`. That gives the project a small review vocabulary that matches its observability focus without claiming live deployment or external usage.

## Cases

- `baseline`: `span volume`, score 217, lane `ship`
- `stress`: `latency skew`, score 210, lane `ship`
- `edge`: `signal loss`, score 124, lane `watch`
- `recovery`: `incident shape`, score 153, lane `ship`
- `stale`: `span volume`, score 256, lane `ship`

## Note

The repository should be understandable without pretending it is larger than it is.
