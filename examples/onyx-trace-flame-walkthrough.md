# Onyx Trace Flame Probe Walkthrough

The fixture is intentionally compact, so the review starts with the cases that pull farthest apart.

| Case | Focus | Score | Lane |
| --- | --- | ---: | --- |
| baseline | span volume | 217 | ship |
| stress | latency skew | 210 | ship |
| edge | signal loss | 124 | watch |
| recovery | incident shape | 153 | ship |
| stale | span volume | 256 | ship |

Start with `stale` and `edge`. They create the widest contrast in this repository's fixture set, which makes them better review anchors than the middle cases.

The next useful expansion would be a malformed fixture around latency skew and incident shape.
