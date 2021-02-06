def sums(arr):
    l=len(arr)
    start=1
    while True:
        if sum(arr[:start])==sum(arr[start+1:]):
            print(sum(arr[:start]),sum(arr[start+1:]))
            return start
        start+=1
print(sums([1,2,3,3]))


def sums(arr):
    l = len(arr)

    pivot_plus = l // 2
    pivot_minus = l // 2
    while True:
        if sum(arr[:pivot_plus]) == sum(arr[pivot_plus + 1:]):
            return pivot_plus
        pivot_plus += 1

        if sum(arr[:pivot_minus]) == sum(arr[pivot_minus:]):
            return pivot_minus
        pivot_minus -= 1



a=[1,2,3,4,5]
print(a[:2])
print(a[3:])