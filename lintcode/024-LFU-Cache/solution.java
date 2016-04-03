public class LFUCache {
    private class CacheNode {
        public final int k;
        public int v;
        public int frequency;

        public CacheNode(int k, int v, int frequency) {
            this.k = k;
            this.v = v;
            this.frequency = frequency;
        }
    }

    private final Map<Integer, CacheNode> cache;
    private final LinkedHashSet[] frequencyList;
    private int lowestFrequency;
    private int maxFrequency;
    private final int maxCacheSize;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.frequencyList = new LinkedHashSet[capacity * 2];
        this.lowestFrequency = 0;
        this.maxFrequency = capacity * 2 - 1;
        this.maxCacheSize = capacity;
        initFrequencyList();
    }

    public void set(int key, int value) {
        CacheNode currentNode = cache.get(key);
        if (currentNode == null) {
            if (cache.size() == maxCacheSize) {
                doEviction();
            }
            LinkedHashSet<CacheNode> nodes = frequencyList[0];
            currentNode = new CacheNode(key, value, 0);
            nodes.add(currentNode);
            cache.put(key, currentNode);
            lowestFrequency = 0;
        } else {
            currentNode.v = value;
        }
        addFrequency(currentNode);
    }

    public int get(int key) {
        CacheNode currentNode = cache.get(key);
        if (currentNode != null) {
            addFrequency(currentNode);
            return currentNode.v;
        } else {
            return -1;
        }
    }

    private void addFrequency(CacheNode currentNode) {
        int currentFrequency = currentNode.frequency;
        if (currentFrequency < maxFrequency) {
            int nextFrequency = currentFrequency + 1;
            LinkedHashSet<CacheNode> currentNodes = frequencyList[currentFrequency];
            LinkedHashSet<CacheNode> nextNodes = frequencyList[nextFrequency];
            moveToNextFrequency(currentNode, nextFrequency, currentNodes, nextNodes);
            cache.put(currentNode.k, currentNode);
            if (lowestFrequency == currentFrequency && currentNodes.isEmpty()) {
                lowestFrequency = nextFrequency;
            }
        } else {
            // hybrid with LRU: put most recently accessed ahead of others
            LinkedHashSet<CacheNode> nodes = frequencyList[currentFrequency];
            nodes.remove(currentNode);
            nodes.add(currentNode);
        }
    }

    private void moveToNextFrequency(CacheNode currentNode, int nextFrequency, LinkedHashSet<CacheNode> currentNodes, LinkedHashSet<CacheNode> nextNodes) {
        currentNodes.remove(currentNode);
        nextNodes.add(currentNode);
        currentNode.frequency = nextFrequency;
    }

    private void doEviction() {
        LinkedHashSet<CacheNode> nodes = frequencyList[lowestFrequency];
        if (!nodes.isEmpty()) {
            Iterator<CacheNode> it = nodes.iterator();
            CacheNode node = it.next();
            it.remove();
            cache.remove(node.k);

            if (!it.hasNext()) {
                findNextLowestFrequency();
            }
        }
    }

    private void findNextLowestFrequency() {
        while (lowestFrequency <= maxFrequency && frequencyList[lowestFrequency].isEmpty()) {
            lowestFrequency++;
        }
        if (lowestFrequency > maxFrequency) {
            lowestFrequency = 0;
        }
    }

    private void initFrequencyList() {
        for (int i = 0; i <= maxFrequency; i++) {
            frequencyList[i] = new LinkedHashSet<CacheNode>();
        }
    }
}