# onyx-trace-flame-probe

`onyx-trace-flame-probe` is a Scala project for Observability. It turns package a Scala local lab for flame analysis with deny and allow fixtures, explainable decision traces, and documented operating limits into a small local model with readable fixtures and a direct verification command.

## Reading Onyx Trace Flame Probe

Start with the README, then open `metadata/project.json` to check the constants behind the examples. After that, `fixtures/cases.csv` shows the compact path and `examples/extended_cases.csv` gives a wider look at the same rule.

## Purpose

This is not a wrapper around a service. It is a self-contained project that shows how the model behaves when demand, capacity, latency, risk, and weight move in different directions.

## Design Sketch

The core is a scoring model over demand, capacity, latency, risk, and weight. That keeps span data, log shape, and latency summaries in one explicit decision path. The threshold is 156, with risk penalty 4, latency penalty 4, and weight bonus 5. The Scala code uses case classes and a compact object API to keep the test path direct.

## Fixture Notes

`examples/extended_cases.csv` adds six named cases. I kept the names plain so failures are easy to read in a terminal: baseline, pressure, surge, degraded, recovery, and boundary.

## What It Does

- Uses fixture data to keep log shape changes visible in code review.
- Includes extended examples for latency summaries, including `surge` and `degraded`.
- Documents incident slices tradeoffs in `docs/operations.md`.
- Runs locally with a single verification command and no external credentials.
- Stores project constants and verification metadata in `metadata/project.json`.

## Setup

Use a normal shell with Scala available on `PATH`. The verifier is written as a PowerShell script because the portfolio was assembled on Windows.

## Verification

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/audit.ps1
```

The audit command checks repository structure and README constraints before it delegates to the verifier.

## Files Worth Reading

- `src`: primary implementation
- `tests`: verification harness
- `fixtures`: compact golden scenarios
- `examples`: expanded scenario set
- `metadata`: project constants and verification metadata
- `docs`: operations and extension notes
- `scripts`: local verification and audit commands

## Limits

The examples cover useful edges, not every edge. A larger version would add malformed-input tests, richer reports, and deeper domain parsers.

## Next Directions

- Add a loader for `examples/extended_cases.csv` and promote selected cases into the language test suite.
- Add a short report command that prints the score breakdown for a single scenario.
- Add malformed input fixtures so the failure path is as visible as the happy path.
- Add one more observability fixture that focuses on a malformed or borderline input.

## Usage

```powershell
powershell -NoProfile -ExecutionPolicy Bypass -File scripts/verify.ps1
```

This runs the language-level build or test path against the compact fixture set.
