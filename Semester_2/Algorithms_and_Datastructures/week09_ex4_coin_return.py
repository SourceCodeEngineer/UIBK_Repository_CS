S_example = [1, 5, 10]
S_counterexample = [1, 20, 50]

S = S_example
#S = S_counterexample

def coin_return(x, y):
	Ss = sorted(S, key=lambda a: -a)

	ret = []
	y -= x
	for val in Ss:
		while y >= val:
			y -= val
			ret.append(val)
	return ret


if __name__ == '__main__':
	import sys

	if len(sys.argv) < 3:
		print(f'usage: {sys.argv[0]} <x> <y>')
	else:
		print(coin_return(int(sys.argv[1]), int(sys.argv[2])))
