.global _start
.text
_start:
    MOV r0, #7
    MOV r1, #42
    BL return_max
max:
    // r0 := max(r0, r1)
    CMP r0, r1
    MOVLT r0, r1
    MOV pc, lr
return_max:
    B max
    MOV r7, #1
    SWI #0
