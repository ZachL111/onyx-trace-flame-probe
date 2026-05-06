# onyx-trace-flame-probe

`onyx-trace-flame-probe` is a compact Scala repository for observability, centered on this goal: Package a Scala local lab for flame analysis with deny and allow fixtures, explainable decision traces, and documented operating limits.

## Why I Keep It Small

The project exists to keep a narrow engineering decision visible and testable. For this repo, that decision is how span volume and signal loss should influence a review result.

## Onyx Trace Flame Probe Review Notes

`stale` and `edge` are the cases worth reading first. They show the optimistic and cautious ends of the fixture.

## Included Behavior

- `fixtures/domain_review.csv` adds cases for span volume and latency skew.
- `metadata/domain-review.json` records the same cases in structured form.
- `config/review-profile.json` captures the read order and the two review questions.
- `examples/onyx-trace-flame-walkthrough.md` walks through the case spread.
- The Scala code includes a review path for `span volume` and `signal loss`.
- `docs/field-notes.md` explains the strongest and weakest cases.

## Internal Model

The core code exposes a scoring path and the added review layer uses `signal`, `slack`, `drag`, and `confidence`. The domain terms are `span volume`, `latency skew`, `signal loss`, and `incident shape`.

The Scala code keeps the review rule close to the tests.

## Try It Locally

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

## Validation

That command is also the regression path. It verifies the domain cases and catches mismatches between the CSV, metadata, and code.

## Scope

This remains a local project with deterministic fixtures. It does not depend on credentials, hosted services, or live data. Future work should add richer malformed inputs before widening the public API.
