
def X(arr):
    # Write your code here
    sums = 0
    mini = 99999
    for i in arr:
        sums += i
        if sums < mini:
            mini = sums

    if mini < 0:
        return abs(mini) + 1
    elif mini > 0:
        pass

