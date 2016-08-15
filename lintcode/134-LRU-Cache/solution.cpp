#include <list>
class LRUCache{
public:
    // @param capacity, an integer
    LRUCache(int capacity) {
        this->capacity = capacity;
    }
    
    // @return an integer
    int get(int key) {
        if (keys.find(key) == keys.end()) {
            return -1;
        } else {
            int value = keys[key]->first;
            values.erase(keys[key]);
            values.push_front({value, key});
            keys[key] = values.begin();
            return value;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    void set(int key, int value) {
        if (keys.find(key) != keys.end()) {
            values.erase(keys[key]);
            values.push_front({value, key});
            keys[key] = values.begin();
        } else if (keys.size() == capacity) {
            keys.erase(values.back().second);
            values.pop_back();
            values.push_front({value, key});
            keys[key] = values.begin();
        } else {
            values.push_front({value, key});
            keys[key] = values.begin();
        }
    }
private:
    int capacity;
    list<pair<int, int>> values; // value and key
    unordered_map<int, list<pair<int, int>>::iterator> keys;
};
