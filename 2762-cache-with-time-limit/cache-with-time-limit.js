var TimeLimitedCache = function() {
    this.map = new Map();
};

TimeLimitedCache.prototype.set = function(key, value, duration) {
    const now = Date.now();
    const expiry = now + duration;

    let exists = false;

    if (this.map.has(key)) {
        const old = this.map.get(key);
        if (old.expiry > now) {
            exists = true;
        }
    }

    this.map.set(key, { value: value, expiry: expiry });
    return exists;
};

TimeLimitedCache.prototype.get = function(key) {
    const now = Date.now();

    if (!this.map.has(key)) return -1;

    const entry = this.map.get(key);

    if (entry.expiry <= now) {
        return -1;
    }

    return entry.value;
};

TimeLimitedCache.prototype.count = function() {
    const now = Date.now();
    let count = 0;

    for (let [key, entry] of this.map) {
        if (entry.expiry > now) {
            count++;
        }
    }

    return count;
};