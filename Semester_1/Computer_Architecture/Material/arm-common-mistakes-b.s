.global _start
.text
_start:
    MOV r0, #4
    MOV r1, #5
    MOV r7, #1
    BL calc
    SWI #0
calc:
    // r0 := (r0 + r1)^2
    ADD r7, r0, r1
    MUL r0, r7, r7
    MOV pc, lr
