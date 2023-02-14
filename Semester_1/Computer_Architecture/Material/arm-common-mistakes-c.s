.global _start
.text
_start:
    MOV r0, #4
    BL g
    MOV r7, #1
    SWI #0
f:
    // r0 := r0^2 + 1
    MUL r1, r0, r0
    ADD r0, r1, #1
    MOV pc, lr
g:
    // r0 := 2 * f(r0 - 1)
    SUB r0, r0, #1
    BL f
    ADD r0, r0, r0
    MOV pc, lr
